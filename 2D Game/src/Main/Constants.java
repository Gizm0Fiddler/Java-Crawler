package src.Main;



public class Constants {
    
    public static class PlayerConstants{
        public static final int SPAWN = 0;
        public static final int IDLE = 1;
        static final int RUNNING = 2;
        static final int DEATH = 3;

        public static int GetSpriteAmount(int player_action){

            switch(player_action) {

                case SPAWN:
                    return 1; //Set to length of animation/# of sprites

                case IDLE:
                    return 1;

                case RUNNING:
                    return 1;

                case DEATH:
                    return 1;

                default:
                    return 1;
            }
        }

        
    }
}
