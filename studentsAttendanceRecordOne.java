public class studentsAttendanceRecordOne {
    public static void main(String[] args) {
        /*
         * You are given a string s representing an attendance record for a student
         * where each character signifies whether the student was absent, late, or
         * present on that day. The record only contains the following three characters:
         * 
         * 'A': Absent.
         * 'L': Late.
         * 'P': Present.
         * The student is eligible for an attendance award if they meet both of the
         * following criteria:
         * 
         * The student was absent ('A') for strictly fewer than 2 days total.
         * The student was never late ('L') for 3 or more consecutive days.
         * Return true if the student is eligible for an attendance award, or false
         * otherwise.
         */
        System.out.println(checkRecord("PPALLL"));
    }
    public static boolean checkRecord(String s){
        int absent = 0;
        int late = 0;

        //loop through the length of the string
        for(int i = 0; i < s.length(); i++){
            //if the char is an 'L' increment late, also check if late is greater than 2, since after 3 consecutive return false,
            if(s.charAt(i) == 'L'){
                late++;
                if(late > 2){
                    return false;
                }
            }else{ //since it is based on consecutive lates, if the value in the string is not 'L' reset late to 0
                late = 0;
            }

            //check if the char iteration is 'A' if it is increment absent. if there are at least 2 absences return false
            if(s.charAt(i) == 'A'){
                absent++;
                if(absent > 1){
                    return false;
                }
            }
        }

        //if the loop successfully complete that means the student is eligible for the attendance award
        return true;
    }
}

/*
 * one liner solution:
 * 
 * return !s.matches(".*LLL.*|.*A.*A.*");
 */