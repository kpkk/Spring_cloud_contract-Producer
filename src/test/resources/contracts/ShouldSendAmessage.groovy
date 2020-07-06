import org.springframework.cloud.contract.spec.*;
Contract.make {
description(
        """ this contract file is to verify the messaging feature """
)
    input {
        label("trigger_fraud")
        triggeredBy("method()")
    }
    outputMessage{
        sentTo("frauds")
        body([surname:"m"])
        headers {
            messagingContentType(applicationJson())
        }

    }
}
