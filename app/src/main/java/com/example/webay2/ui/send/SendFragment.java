package com.example.webay2.ui.send;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.webay2.R;
import com.example.webay2.Session;
import com.example.webay2.entities.Group;
import com.example.webay2.entities.Message;
import com.example.webay2.entities.User;

public class SendFragment extends Fragment {

    private SendViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        Session session = new Session(getContext());
        User user = session.getUser();
        final TextView textView = root.findViewById(R.id.text_send);
        sendViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);

                StringBuilder sb = new StringBuilder();
                for(Group group : user.getGroups())
                {
                    sb.append("Group N° : "+group.getId()+"\n\n");
                    for (Message message : group.getMessages()) {
                            sb.append("\t"+message.getMessage()+"\n\t\t"+message.getCreator().getName()+" At "+message.getCreatedAt().toString());
                            sb.append("\n\n");
                    }
                    sb.append("\n\n\n");
                }

                textView.setText("\n"+user.getName().toUpperCase()+":\n\n"+sb.toString());
                textView.setMovementMethod(new ScrollingMovementMethod());
            }
        });
        return root;
    }
}