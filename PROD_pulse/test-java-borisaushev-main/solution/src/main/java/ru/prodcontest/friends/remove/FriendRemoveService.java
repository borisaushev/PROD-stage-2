package ru.prodcontest.friends.remove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.prodcontest.auth.signin.token.Jwt.JwtTokenService;
import ru.prodcontest.userInfo.repository.UserRepository;

@Service
public class FriendRemoveService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    FriendRemoveRepository friendRemoveRepository;

    @Autowired
    JwtTokenService jwtTokenService;

    public boolean userDoesntExists(String login) {
        return userRepository.userExistsWithProperty("login", login) == Boolean.FALSE;
    }

    public void removeFriend(String login, String token) {
        if(userDoesntExists(login))
            return;

        int requestAuthorId = jwtTokenService.getIdByToken(token);
        int friendToRemoveId = userRepository.getIdByLogin(login);

        friendRemoveRepository.removeFriend(requestAuthorId, friendToRemoveId);

    }

}
