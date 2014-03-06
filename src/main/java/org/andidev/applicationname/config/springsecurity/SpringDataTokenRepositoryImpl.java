package org.andidev.applicationname.config.springsecurity;

import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.RememberMeToken;
import org.andidev.applicationname.repository.RememberMeTookenRepository;
import org.joda.time.DateTime;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Slf4j
public class SpringDataTokenRepositoryImpl implements PersistentTokenRepository {

    @Inject
    RememberMeTookenRepository rememberMeTookenRepository;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        RememberMeToken rememberMeToken = new RememberMeToken(token.getUsername(), token.getSeries(), token.getTokenValue(), new DateTime(token.getDate()));
        rememberMeTookenRepository.save(rememberMeToken);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        RememberMeToken rememberMeToken = rememberMeTookenRepository.findBySeries(series);
        rememberMeToken.setToken(tokenValue);
        rememberMeToken.setLastUsed(new DateTime(lastUsed));
        rememberMeTookenRepository.save(rememberMeToken);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String series) {
        RememberMeToken rememberMeToken = rememberMeTookenRepository.findBySeries(series);
        if (rememberMeToken == null) {
            log.debug("No remember me token for series '{}' was found.", series);
            return null;
        }
        return new PersistentRememberMeToken(rememberMeToken.getUsername(), rememberMeToken.getSeries(), rememberMeToken.getToken(), rememberMeToken.getLastUsed().toDate());
    }

    @Override
    public void removeUserTokens(String username) {
        List<RememberMeToken> rememberMeTookens = rememberMeTookenRepository.findByUsername(username);
        for (RememberMeToken rememberMeToken : rememberMeTookens) {
            rememberMeTookenRepository.delete(rememberMeToken);
        }
    }

}
