package com.consumer.emailnotofier.emailnotofier.RequestModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailNotifierModel {

    private String receiverMail;
    private String subject;
    private String message;




}
