package si.poljansek.lenart.notiself;

import java.util.Calendar;


import android.app.TimePickerDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimeDisplayPicker extends TextView implements TimePickerDialog.OnTimeSetListener {
    private Context _context;

    public TimeDisplayPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        _context = context;
    }

    public TimeDisplayPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        _context = context;
        setAttributes();
    }

    public TimeDisplayPicker(Context context) {
        super(context);
        _context = context;
        setAttributes();
    }

    private void setAttributes() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
    }

    private void showDateDialog() {
        final Calendar c = Calendar.getInstance();
        TimePickerDialog dp = new TimePickerDialog(_context, this, c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true);
        dp.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        setText(String.format("%s%s%s",hourOfDay,":",minute));
    }


}
