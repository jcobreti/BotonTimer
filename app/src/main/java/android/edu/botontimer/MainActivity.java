package android.edu.botontimer;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
  private int color_tocado;
    private int nveces;
    private long currentTime0, currentTime1;
    private long intervalo, min, seg;
    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.textView);
        this.nveces = 0;
        this.color_tocado = ResourcesCompat.getColor(getResources(), R.color.tocado, null);
        //currentTime0 = Calendar.getInstance().getTimeInMillis();
        currentTime0=System.currentTimeMillis();
    }

    private void cerrar ()
    {   currentTime1= Calendar.getInstance().getTimeInMillis();

        intervalo=currentTime1-currentTime0;
        intervalo=intervalo/1000;//Ya lo tengo en segundos

        min=intervalo/60; //Calculo los minutos
        intervalo=intervalo-(min*60);//resto los minutos y asi me quedan ya los segundos
        seg=intervalo;

        Toast.makeText(this, min+"'"+seg+"''", Toast.LENGTH_LONG).show();

    }

    public void ocultarBoton(View view) {
        view.setVisibility(View.INVISIBLE);//View.GONE
    }

    public void cambiaColor(View v) {
        Object tag = v.getTag();//obtengo la info asociada

       // if (tag==null)
       // {Quito el if porque lo he modificado solo para un boton y la segunda vez TAG ya no es NULL
            this.nveces++;
            t1.setText("Van: "+nveces);
            v.setTag("#FFF");//le hago una marquita a la caja tocada
            v.setBackgroundColor(this.color_tocado);
            //v.setVisibility(View.GONE);
            if (this.nveces==12) {cerrar();}
       // }
    }
}