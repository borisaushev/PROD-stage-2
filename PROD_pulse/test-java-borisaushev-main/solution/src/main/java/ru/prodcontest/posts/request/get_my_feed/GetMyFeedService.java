package ru.prodcontest.posts.request.get_my_feed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.prodcontest.posts.post.Post;
import ru.prodcontest.userInfo.repository.UserRepository;

import java.util.List;

@Service
public class GetMyFeedService {

    @Autowired
    GetMyFeedRepository repository;

    @Autowired
    UserRepository userRepository;


    public List<Post> getMyFeed(int userId, int limit, int offset) {

        String login = userRepository.getLoginById(userId);

        List<Post> myFeed = repository.getMyFeed(login, limit, offset);

        return myFeed;

    }
}
