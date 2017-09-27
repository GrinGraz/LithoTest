package cl.yapo.lithotest.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ComponentContext c = new ComponentContext(this);

        final LithoView lithoView = LithoView.create(
                this /* context */,
                Text.create(c)
                        .text("Hello, World!")
                        .textSizeDip(50)
                        .build());

        setContentView(lithoView);
    }
}
