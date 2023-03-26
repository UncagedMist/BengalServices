package tbc.uncagedmist.bengalservices.Common;

import android.content.Context;
import android.content.Intent;

public class Common {
    public static final String RATION_E = "https://food.wb.gov.in/Dynamic.aspx?page_id=71";
    public static final String RATION_STATUS = "https://wbpds.wb.gov.in/(S(oddkhf2khvz3thks3ekiujwg))/CheckRationCardStatus.aspx";
    public static final String RATION_AADHAAR = "https://wbpds.wb.gov.in/(S(s4ezo2h0sxerqpd152sh5kic))/Check_EKYC_Status.aspx";
    public static final String RATION_ENTITLEMENT = "https://food.wb.gov.in/Dynamic.aspx?page_id=22";
    public static final String RATION_FORMS = "https://food.wb.gov.in/Dynamic.aspx?page_id=72";
    public static final String RATION_FPS = "https://food.wb.gov.in/food/PrintFPS.aspx";
    public static final String RATION_NEW = "https://wbpds.wb.gov.in/(S(pcavr3jjaetm2uao0nfdgww0))/digitalportal/index.aspx?id=3";
    public static final String RATION_NEW_MEMBER = "https://wbpds.wb.gov.in/(S(hqomudi30any5qxomo2zty5n))/Digitalportal/index.aspx";
    public static final String RATION_EDIT = "https://wbpds.wb.gov.in/(S(lrt3uvdu0uioe0qjwlttxae2))/Digitalportal/index.aspx";
    public static final String RATION_SHIFT = "https://wbpds.wb.gov.in/(S(zpwnbyl2mxozgusbrebzeytt))/Digitalportal/index.aspx";
    public static final String RATION_CANCEL = "https://wbpds.wb.gov.in/(S(s44tfkqlbdkj4md4afxpd40h))/Digitalportal/index.aspx";
    public static final String RATION_CATEGORY = "https://wbpds.wb.gov.in/(S(g3tpwpjgu1xo0t4wihaj5cct))/Digitalportal/index.aspx";
    public static final String RATION_NON = "https://wbpds.wb.gov.in/(S(5d1p5cujeu3kmvsvvnpbuoi3))/digitalportal/index.aspx?id=3";
    public static final String RATION_KEROSENE = "https://wbpds.wb.gov.in/(S(tlxgckytqvdhnhimqim50pkz))/Digitalportal/index.aspx";
    public static final String RATION_MOBILE = "https://wbpds.wb.gov.in/(S(topf0xsxpccoxu1f0r5i0m4j))/EKYC_otp.aspx";
    public static final String RATION_E_RATION = "https://wbpds.wb.gov.in/(S(oghdex0ufhnp4kcjmrrh24wv))/Digitalportal/index.aspx";


    //Voter id URLs
    public static final String VOTER_REPRINT = "https://voterportal.eci.gov.in/";
    public static final String TRACK_VOTER = "https://www.nvsp.in/";
    public static final String VOTER_SERVICES = "https://www.nvsp.in/";
    public static final String SEARCH_VOTER = "https://electoralsearch.in/";
    public static final String APPLY_VOTER = "https://www.nvsp.in/Account/Login";
    public static final String DOWNLOAD_VOTER = "https://www.nvsp.in/";
    public static final String EDIT_VOTER = "https://www.nvsp.in/";
    public static final String SEARCH_AWAS = "https://pmaymis.gov.in/Open/Find_Beneficiary_Details.aspx";
    public static final String BENE_AWAS = "https://rhreporting.nic.in/netiay/AdvanceSearch.aspx";
    public static final String LIST_AWAS = "https://rhreporting.nic.in/netiay/SocialAuditReport/BeneficiaryDetailForSocialAuditReport.aspx";


    //panchayat urls
    public static final String P_SCHEDULE = "https://ceowestbengal.nic.in/UploadFiles/SRER2023/SRER_2023_schedule.pdf";
    public static final String P_ONLINE = "https://www.nvsp.in//";
    public static final String P_ELECTORAL = "https://ceowestbengal.nic.in/DistrictList";
    public static final String P_ROLL = "https://ceowestbengal.nic.in/RollRevision";
    public static final String P_BLO = "https://ceowestbengal.nic.in/UploadFiles/BLO.pdf";
    public static final String P_BLA = "https://ceowestbengal.nic.in/UploadFiles/SRER2023/BLA.pdf";
    public static final String P_CLAIM = "https://wbceo.in/wb-cao";
    public static String CurrentURL;

    public static void shareApp(Context context)    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String message = "Never Miss A Thing About Ration Card. Install Bengal Ration Card App and Stay Updated! \n https://play.google.com/store/apps/details?id=tbc.uncagedmist.bengalservices";
        intent.putExtra(Intent.EXTRA_TEXT, message);
        context.startActivity(Intent.createChooser(intent, "Share Bengal Ration Card App Using"));
    }
}
