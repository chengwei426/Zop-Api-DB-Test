package com.iwhalecloud.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardInfo implements Serializable {

    private String ReaderName;

    private String LastError;

    private Integer Card_Version;

    private String CardType;

    private Boolean IsFingerprintVerified;

    private String VerificationMode;

    private String MaxFailedAttempts;

    private String LeftHandCode;

    private String RightHandCode;

    private String OriginalName;

    private String GMPCName;

    private String KPTName;

    private String NRIC;

    private String OldIC;

    private String OtherID;

    private String Gender;

    private String DOB;

    private String POB;

    private String DateIssue;

    private String Citizenship;

    private String Race;

    private String Religion;

    private String Address1;

    private String Address2;

    private String Address3;

    private Integer Postcode;

    private String City;

    private String State;

    private String East_Malaysian_Origin;

    private String Criminal_Record;

    private String Restricted_Residence;

    private String Green_Card_Expiry;

    private String Green_Card_Nationality;

    private String PR_Nationality_ID;

    private String Photo;

}
