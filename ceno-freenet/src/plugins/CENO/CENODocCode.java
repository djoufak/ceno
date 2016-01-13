package plugins.CENO;

/**
 * Error Codes as described in the errorConditions Document
 * Useful for inter-agent error handling
 */
public enum CENODocCode {
    // CC //
    CC_NO_CONFIG_FILE(1100),
    CC_MALFORMED_URL(1101),
    CC_LCS_CONNECT(1200),
    CC_LCS_MALFORMED_RESPONSE(1201),
    CC_LCS_ERR(1202),
    CC_RS_CONNECT(1203),
    CC_MISSING_VIEW(1102),
    
    // LCS //
    LCS_MALFORMED_URL(2110),
    LCS_URL_DECODE_ERR(2112),
    LCS_WILL_NOT_SERVE(2120),
    LCS_INTERNAL(2140),
    LCS_LOOKUP_FAILURE(2130),
    LCS_FREENET_NODE_NOT_READY(2300),
    LCS_FREENET_COULD_NOT_CONNECT_TO_PEERS(2301),

    // RS //
    RS_MALFORMED_URL(3111),
    RS_URL_DECODE_ERR(3112),
    RS_WILL_NOT_SERVE(2120),
    RS_INTERNAL(3140),
    RS_WOT_ERR(3310),
    RS_FREEMAIL_ERR(3330),
    RS_FREEMAIL_SMTP(3410),
    
    // RR //
    RR_BS_CONNECT(4200),
    RR_DATABASE_FAILURE(4103),
    RR_BUNDLE_TIMEOUT(4201),
    RR_BI_CONNECT(4202),
    
    // BS //
    BS_BUNLDING_ERR(5400),
    BS_INTERNET_ERR(5401),
    BS_NO_CONFIG_FILE(5100),
    BS_RS_CLOSED_CONN(5200),
    
    // BI //
    BI_INITIALIZING(6101),
    BI_MALFORMED_URL(6102),
    BI_NOT_READY_FOR_INSERTIONS(6300),
    BI_COULD_NOT_INSERT(6301),
    BI_BUNDLE_MALFORMED(6200),
    
    HANDLE_INTERNALLY(0);

    private int code;

    CENODocCode(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return this.code;
    }
}
