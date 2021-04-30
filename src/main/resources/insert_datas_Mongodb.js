db.notes.drop();

var document1 = {
    _id  : "607c548c7c65654ca2a8f44d",
    patientId : "1",
    note : "BlaBla Tests 1"
};

var document2 = {
    _id  : "707c548c7c65654ca2a8f44d",
    patientId : "2",
    note : "BlaBla Tests 2"
};

var document3 = {
    _id  : "807c548c7c65654ca2a8f44d",
    patientId : "3",
    note : "BlaBla Tests 3"
};

db.notes.insert(document1);
db.notes.insert(document2);
db.notes.insert(document3);