package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChatAction {
    @JsonProperty("typing")
    TYPING,
    @JsonProperty("upload_photo")
    UPLOAD_PHOTO,
    @JsonProperty("record_video")
    RECORD_VIDEO,
    @JsonProperty("upload_video")
    UPLOAD_VIDEO,
    @JsonProperty("record_voice")
    RECORD_VOICE,
    @JsonProperty("upload_voice")
    UPLOAD_VOICE,
    @JsonProperty("upload_document")
    UPLOAD_DOCUMENT,
    @JsonProperty("find_location")
    FIND_LOCATION,
    @JsonProperty("record_video_note")
    RECORD_VIDEO_NOTE,
    @JsonProperty("upload_video_note")
    UPLOAD_VIDEO_NOTE
}
