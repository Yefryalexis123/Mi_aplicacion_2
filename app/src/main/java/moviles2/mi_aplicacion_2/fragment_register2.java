package moviles2.mi_aplicacion_2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_register2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_register2 extends Fragment implements View.OnClickListener {

    private Button register;
    private EditText full_name;
    private EditText telephono_number;
    private EditText email;

    private Context mContext;
    private Spinner mSpinner;

    private EditText password;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_register2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_register2.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_register2 newInstance(String param1, String param2) {
        fragment_register2 fragment = new fragment_register2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        register = (Button) getActivity().findViewById(R.id.idRegistter);
        full_name = (EditText) getActivity().findViewById(R.id.idNombre);
        telephono_number = (EditText) getActivity().findViewById(R.id.idtelephone);
        email = (EditText) getActivity().findViewById(R.id.idemail);
        mSpinner = (Spinner) getActivity().findViewById(R.id.idSpinner);

        register.setOnClickListener(this);
    }


   /*
           public void capturarSpinner(View view){
        String  seleccion = mSpinner.getSelectedItem().toString();
        System.out.println(seleccion);
    }

         private void setupSpinner() {
        // Supongamos que tienes una lista de opciones

        String [] opcioneslist = getResources().getStringArray(R.array.nacionalidad);


        // Crea un ArrayAdapter usando el contexto y el layout predeterminado para los elementos de la lista

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opcioneslist);
        mSpinner.setAdapter(adapter);
    }*/

    @Override
    public void onClick(View v) {
        if (v.getId() == register.getId()){
            Navigation.findNavController(v).navigate(R.id.fragment_inicio_sesion);
        }
    }


}