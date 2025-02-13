import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class GasInstallationChecklistApplication {

    public static void main(String[] args) {
        SpringApplication.run(GasInstallationChecklistApplication.class, args);
    }

    @Entity
    public static class Question {  // Note: static inner class
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String question;
        // ... getters and setters ...
        public Question() {}
        public Question(String question) { this.question = question; }

    }

    @Entity
    public static class Response { // Note: static inner class
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne
        @JoinColumn(name = "question_id")
        private Question question;
        private String response;
        private String comment;
        private String attachmentPath;
        // ... getters and setters ...
        public Response() {}
        public Response(Question question, String response, String comment, String attachmentPath) {
            this.question = question;
            this.response = response;
            this.comment = comment;
            this.attachmentPath = attachmentPath;
        }
    }

    @Entity
    public static class Responder {  // Note: static inner class
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String responderName;
        private int responderAge;
        // ... getters and setters ...
        public Responder() {}
        public Responder(String responderName, int responderAge) {
            this.responderName = responderName;
            this.responderAge = responderAge;
        }
    }

    interface QuestionRepository extends JpaRepository<Question, Long> {}
    interface ResponseRepository extends JpaRepository<Response, Long> {}
    interface ResponderRepository extends JpaRepository<Responder, Long> {}


    @Controller
    public static class ChecklistController { // Note: static inner class

        private final QuestionRepository questionRepository;
        private final ResponseRepository responseRepository;
        private final ResponderRepository responderRepository;

        public ChecklistController(QuestionRepository questionRepository, ResponseRepository responseRepository, ResponderRepository responderRepository) {
            this.questionRepository = questionRepository;
            this.responseRepository = responseRepository;
            this.responderRepository = responderRepository;
        }

        private static final String UPLOAD_DIRECTORY = "uploads";

        @GetMapping("/")
        public String getChecklist(Model model) {
            List<Question> questions = questionRepository.findAll();
            model.addAttribute("questions", questions);
            model.addAttribute("responder", new Responder());
            return "index";
        }

        @PostMapping("/")
        public String submitChecklist(@ModelAttribute Responder responder, @RequestParam Map<String, String> responses, @RequestParam Map<String, MultipartFile> attachments, Model model) {
            responderRepository.save(responder);
            for (Question question : questionRepository.findAll()) {
                // ... (rest of the controller code - same as before) ...
            }
            model.addAttribute("message", "Checklist submitted successfully!");
            return "success";
        }
    }
}
