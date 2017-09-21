package r3info.com.frasedodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    private Button BotaoNovaFrase;
    private String UltimaFraseMostrada;
    private String FraseAtual;
    private TextView TextoNovaFrase;
    private int intAtual;
    private int intRemover;
    List<String> FrasesNaoLidas = new LinkedList<>(Arrays.asList(""));
    List<String> FrasesPadrao = new LinkedList<>(Arrays.asList("Rir de tudo é coisa dos tontos, mas não rir de nada é coisa dos estúpidos.",
            "Apresso-me a rir de tudo, com medo de ser obrigado a chorar.",
            "Não rir, nem lamentar-se, nem odiar mas compreender.",
            "Tenho evitado cuidadosamente rir-me dos atos humanos, ou desprezá-los; o que tenho feito é tratar de compreendê-los.",
            "Se você não aprende a rir das dificuldades, você não terá nada para rir quando estiver velho.",
            "O moço que não chorou é um selvagem, e o velho que não quer rir é um tolo."));

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BotaoNovaFrase = findViewById(R.id.btnFrase);
        TextoNovaFrase = findViewById(R.id.txtFrase);

        FrasesNaoLidas.remove(0);
        FrasesNaoLidas.addAll(FrasesPadrao);

        intAtual = new Random().nextInt(FrasesNaoLidas.size());
        TextoNovaFrase.setText(FrasesNaoLidas.get(intAtual));
        FrasesNaoLidas.remove(intAtual);

        BotaoNovaFrase.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                if (FrasesNaoLidas.size() == 0)
                {
                    FrasesNaoLidas.addAll(FrasesPadrao);

                    for(int i=0; i < FrasesNaoLidas.size(); i++){
                        if(FrasesNaoLidas.get(i).equals(UltimaFraseMostrada))
                        {
                            intRemover = i;
                            break;
                        }
                    }

                    Log.d("REMOVER...", FrasesNaoLidas.get(intRemover) + " == " + UltimaFraseMostrada);
                    FrasesNaoLidas.remove(intRemover);

                }

                intAtual = new Random().nextInt(FrasesNaoLidas.size());
                TextoNovaFrase.setText(FrasesNaoLidas.get(intAtual));
                UltimaFraseMostrada = FrasesNaoLidas.get(intAtual);
                FrasesNaoLidas.remove(intAtual);
            }
        });
    }
}
