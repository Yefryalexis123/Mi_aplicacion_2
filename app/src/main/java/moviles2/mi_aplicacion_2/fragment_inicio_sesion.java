package moviles2.mi_aplicacion_2;

import android.database.Cursor;
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
import android.widget.Toast;

import moviles2.mi_aplicacion_2.data.Huesped;
import moviles2.mi_aplicacion_2.data.HotelDBHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_inicio_sesion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_inicio_sesion extends Fragment implements View.OnClickListener {
    private HotelDBHelper db;
    private Button btLogin_in;
    private Button btSing_in;
    private EditText textEmail;
    private EditText textPassword;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_inicio_sesion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_inicio_sesion.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_inicio_sesion newInstance(String param1, String param2) {
        fragment_inicio_sesion fragment = new fragment_inicio_sesion();
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
        return inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btLogin_in = (Button) getActivity().findViewById(R.id.btLogin_in);
        btSing_in = (Button) getActivity().findViewById(R.id.btSing_in);
        textEmail = (EditText) getActivity().findViewById(R.id.txtMail);
        textPassword = (EditText) getActivity().findViewById(R.id.txtPassword);

        btLogin_in.setOnClickListener(this);
        btSing_in.setOnClickListener(this);
        db = new HotelDBHelper(getContext());
    }

    @Override
    public void onClick(View v) {
        Cursor cursor = db.getHuespedByUser(textEmail.getText().toString(), textPassword.getText().toString());
        if (cursor.moveToNext()) {
            Huesped hps = new Huesped(cursor);
            if (v.getId() == btLogin_in.getId()) {
                Bundle bundle = new Bundle();
                bundle.putString("userName", hps.getNombre());
                Navigation.findNavController(v).navigate(R.id.fragment_menu, bundle);
            }

        } else if (v.getId() == btSing_in.getId()) {
            Navigation.findNavController(v).navigate(R.id.fragment_register2);

        } else {
            Toast.makeText(getContext(), "Credenciales invalidas", Toast.LENGTH_LONG).show();

        }
    }
}