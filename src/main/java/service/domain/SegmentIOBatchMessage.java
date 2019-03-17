package service.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class SegmentIOBatchMessage {

    private String messageId;

    private LocalDateTime sendAt;

    List<Map<String, Object>> batch;

}
