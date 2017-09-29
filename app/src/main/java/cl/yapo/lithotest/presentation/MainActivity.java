package cl.yapo.lithotest.presentation;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.OrientationHelper;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.ComponentRenderInfo;
import com.facebook.litho.widget.LinearLayoutInfo;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.RecyclerBinder;
import com.facebook.litho.widget.Text;

import cl.yapo.lithotest.presentation.litho.ListItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ComponentContext c = new ComponentContext(this);

        /*final LithoView lithoView = LithoView.create(
                this *//* context *//*,
                Text.create(c)
                        .text("Hello, World!")
                        .textSizeDip(50)
                        .build());*/

        //final Component text = ListItem.create(c).build();

        final RecyclerBinder recyclerBinder = new RecyclerBinder.Builder()
                .layoutInfo(new LinearLayoutInfo(this, OrientationHelper.VERTICAL, false))
                .build(c);

        final Component component = Recycler.create(c)
                .binder(recyclerBinder)
                .build();

        addContent(recyclerBinder, c);

        setContentView(LithoView.create(c, component));
    }

    private static void addContent(RecyclerBinder recyclerBinder, ComponentContext context) {
        for (int i = 0; i < 32; i++) {
            /*recyclerBinder.insertItemAt(
                    i,
                    ComponentRenderInfo.create()
                            .component(ListItem.create(context).build())
                            .build());*/
            ComponentRenderInfo.Builder componentRenderInfoBuilder = ComponentRenderInfo.create();
            componentRenderInfoBuilder.component(
                    ListItem.create(context)
                            .color(i % 2 == 0 ? Color.WHITE : Color.LTGRAY)
                            .title("Hello, world!")
                            .subtitle("Litho tutorial")
                            .build());
            recyclerBinder.insertItemAt(i, componentRenderInfoBuilder.build());
        }
    }
}
