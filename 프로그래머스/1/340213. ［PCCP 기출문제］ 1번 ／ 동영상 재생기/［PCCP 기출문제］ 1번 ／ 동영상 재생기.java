class Solution {
    int video_length;
    int position;
    int skip_start;
    int skip_end;

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        video_length = parseStringToInt(video_len);
        position = parseStringToInt(pos);
        skip_start=parseStringToInt(op_start);
        skip_end=parseStringToInt(op_end);

        skip();
        for (String command : commands) {
            if (command.equals("prev")) {
                prev();
                skip();
            } else if (command.equals("next")) {
                next();
                skip();
            }
        }
        answer = parseIntToString();
        return answer;
    }
    private int parseStringToInt(String time){
        String[] splitTime = time.split(":");
        
        int minute = Integer.parseInt(splitTime[0]);
        int second = Integer.parseInt(splitTime[1]);
        return minute*60 + second;
    }
    private String parseIntToString(){
        String prevMinute = Integer.toString(position/60);
        String prevSecond = Integer.toString(position%60);
        
        String parseMinute = String.format("%2s",prevMinute).replace(" ","0");
        String parseSecond = String.format("%2s",prevSecond).replace(" ","0");
        return parseMinute+":"+parseSecond;
    }
    private void prev(){
        position -= 10;
            
        if(position < 0) {
            position =0;
        }
    }
    private void next(){
        position += 10;

        if(position>video_length){
            position = video_length;
        }
    }
    private void skip(){
        if(position >= skip_start && position <= skip_end){
            position = skip_end;
        }
    }
}