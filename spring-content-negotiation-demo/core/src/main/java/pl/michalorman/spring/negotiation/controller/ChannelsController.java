package pl.michalorman.spring.negotiation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.michalorman.spring.negotiation.api.ChannelsResponse;
import pl.michalorman.spring.negotiation.model.Channel;

@Controller
@RequestMapping("/channels")
public class ChannelsController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ChannelsResponse list() {
        ChannelsResponse response = new ChannelsResponse();
        response.addChannel(new Channel("JavaTV", "http://java.tv/stream", "Spring in Action"));
        response.addChannel(new Channel("Rails World", "http://rails.tv/stream", "Rails 3.1 in Action"));
        response.addChannel(new Channel("Developer.TV", "http://developer.tv/stream", "Meet Emacs"));
        return response;
    }

}
