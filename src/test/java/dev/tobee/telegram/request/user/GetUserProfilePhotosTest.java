package dev.tobee.telegram.request.user;

import java.util.OptionalInt;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.model.message.UserProfilePhotos;
import dev.tobee.telegram.request.body.GetUserProfilePhotosBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetUserProfilePhotosTest {

    @Test
    void checkValidRequest() {
        GetUserProfilePhotos getUserProfilePhotos = new GetUserProfilePhotos(
                new GetUserProfilePhotosBody(159L, OptionalInt.empty(), OptionalInt.empty())
        );

        Assertions.assertEquals(getUserProfilePhotos.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<UserProfilePhotos>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("getUserProfilePhotos", getUserProfilePhotos.getMethod());
        Assertions.assertTrue(getUserProfilePhotos.getBody().isPresent());
    }
}
