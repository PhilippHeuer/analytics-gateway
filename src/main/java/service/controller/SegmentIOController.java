package service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import service.domain.SegmentIOBatchMessage;

import java.util.List;
import java.util.Map;

/**
 * SegmentIO API - V1
 */
@RestController
@RequestMapping("/segmentio/v1")
@Slf4j
public class SegmentIOController {

    private String endpointName = "Segment.IO";

    /**
     * Batch
     *
     * @return
     */
    @RequestMapping("/batch")
    public Mono<ResponseEntity> batchProcessing(
        @RequestHeader(value="Authorization") String authorization,
        @RequestHeader(value="User-Agent") String userAgent,
        @RequestBody SegmentIOBatchMessage requestBody) {
        // process each entry
        requestBody.getBatch().forEach(request -> {
            String type = (String) request.get("type");

            if (type.equalsIgnoreCase("identify")) {
                // parse identify
                log.info("{}: Received `identify` message.", endpointName);
                log.info("Body: {}", request);
            } else if (type.equalsIgnoreCase("track")) {
                // parse track event
                log.info("{}: Received `track` message.", endpointName);
                log.info("Body: {}", request);
            }
        });

        return Mono.just(new ResponseEntity(HttpStatus.NO_CONTENT));
    }
}
