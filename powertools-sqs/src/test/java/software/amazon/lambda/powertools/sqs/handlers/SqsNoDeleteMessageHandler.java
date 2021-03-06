package software.amazon.lambda.powertools.sqs.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import software.amazon.lambda.powertools.sqs.LargeMessageHandler;

public class SqsNoDeleteMessageHandler implements RequestHandler<SQSEvent, String> {

    @Override
    @LargeMessageHandler(deletePayloads = false)
    public String handleRequest(SQSEvent sqsEvent, Context context) {
        return sqsEvent.getRecords().get(0).getBody();
    }
}