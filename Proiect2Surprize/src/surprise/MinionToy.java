package surprise;

public class MinionToy implements ISurprise{
    private static String[] minionNames = {"Dave", "Carl", "Kevin", "Stuart", "Jerry", "Tim"};
    private String minionName;
    private static int index;

    public MinionToy(String minionName) {
        this.minionName = minionName;
    }

    public static MinionToy generate() {
        MinionToy minion = new MinionToy(minionNames[MinionToy.index]);
        if(MinionToy.index == minionNames.length - 1) {
            MinionToy.index = 0;
        } else {
            MinionToy.index++;
        }
        return minion;
    }

    @Override
    public void enjoy() {
        System.out.println("Felicitari! Ai primit minionul " + this.minionName);
    }

}
