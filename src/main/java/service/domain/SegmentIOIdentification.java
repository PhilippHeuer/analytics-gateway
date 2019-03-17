package service.domain;

import java.time.LocalDateTime;
import java.util.Map;

public class SegmentIOIdentification {

    String type;

    String messageId;

    String userId;

    LocalDateTime timestamp;

    Map<String, String> traits;

    Map<String, Map<String, String>> context;
}
