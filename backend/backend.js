import { initializeApp } from "firebase/app";
import { getDatabase, ref, child, get, set, onValue, exists, getChildrenCount } from "firebase/database";

const firebaseConfig = {
  databaseURL: "https://crowdalertproject-default-rtdb.firebaseio.com",
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);


// Initialize Realtime Database and get a reference to the service
const db = getDatabase(app);
const reportsLiveRef = ref(db, 'reports/');
const reportsNumRef = ref(db, 'reportsNum/');
const reportsNum = 0;

if (!reportsNumRef.exists()) set(ref(db, 'reportsNum/'), {
    count: 0,
});
onValue(reportsNumRef, (snapshot) => {
    const data = snapshot.val();
    reportsNum = data;
});

function getReportCount() {
    return reportsLiveRef.getChildrenCount();
}


