package Model;

import android.widget.LinearLayout;
import android.widget.TextView;

public class ExtraLogic {

    //method for setting the error TextView to any given string
    public void setError(TextView txerror, String errormsg) {
        txerror.setText(errormsg);
    }
}
