package hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HelloWebController {

    @Autowired
    private EurekaClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index(Model model) throws JsonProcessingException, JSONException {

        JSONObject request = new JSONObject();
        request.put("username", "World");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);

        ResponseEntity<String> response = restTemplate.exchange("http://hello/hello", HttpMethod.POST, entity, String.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            model.addAttribute("error", "Failed contacting hello service...");
            return "index";
        }

        JsonNode root = new ObjectMapper().readTree(response.getBody());
        model.addAttribute("message", root.get("message").asText());

        return "index";
    }

}
