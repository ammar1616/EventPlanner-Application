package com.example.final_project;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataAccessObject_Events {

    private DatabaseReference databaseReference;

    public DataAccessObject_Events() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Events.class.getSimpleName());
    }

    public Task<Void> add(Events ev) {
        return databaseReference.push().setValue(ev);
    }

    public Task<Void> delete(String key) {
        return databaseReference.child(key).removeValue();
    }
}
