package cobos.santiago.tresenralla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private int jugadores;
    private int[] CASILLAS;
    private Partida partida;

    private Button btUnJugador;
    private Button btDosJugadores;
    private ImageView ivCasilla;
    private RadioGroup rgDificultad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btUnJugador=(Button)findViewById(R.id.btUnJugador);
        btDosJugadores=(Button)findViewById(R.id.btDosJugadores);

        CASILLAS = new int[9];

        CASILLAS[0]=R.id.ivCasilla1;
        CASILLAS[1]=R.id.ivCasilla2;
        CASILLAS[2]=R.id.ivCasilla3;
        CASILLAS[3]=R.id.ivCasilla4;
        CASILLAS[4]=R.id.ivCasilla5;
        CASILLAS[5]=R.id.ivCasilla6;
        CASILLAS[6]=R.id.ivCasilla7;
        CASILLAS[7]=R.id.ivCasilla8;
        CASILLAS[8]=R.id.ivCasilla9;
    }

    public void aJugar(View view){
        for(int cadaCasilla:CASILLAS){
            ivCasilla=(ImageView) findViewById(cadaCasilla);
            ivCasilla.setImageDrawable(null);
        }

        jugadores=1;

        if(view.getId()==R.id.btDosJugadores){
            jugadores=2;
        }

        rgDificultad=(RadioGroup) findViewById(R.id.rgDificultad);
        int id = rgDificultad.getCheckedRadioButtonId();
        int dificultad=0;
        switch (id){
            case R.id.rbFacil:
                dificultad=1;
                break;
            case R.id.rbNormal:
                dificultad=2;
                break;
            case R.id.rbImposible:
                dificultad=3;
                break;
        }

        partida = new Partida(dificultad);

        btUnJugador.setEnabled(false);
        btDosJugadores.setEnabled(false);
        rgDificultad.setAlpha(0);
    }

}