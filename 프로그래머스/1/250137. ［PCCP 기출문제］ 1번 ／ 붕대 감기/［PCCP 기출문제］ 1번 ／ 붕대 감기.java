class Solution{
        int skillLength;
        int healing;
        int plusHeal;
        int maxHealth;
        int nowHealth;
        int healCount=0;

        public int solution(int[] bandage, int health, int[][] attacks) {
            int answer = 0;
            init(bandage, health);

            int lastAttack = attacks[attacks.length - 1][0];

            int attackIndex = 0;
            int[] attack;
            for(int i=0;i<=lastAttack;i++){
                attack = attacks[attackIndex];

                //attack
                if(i == attack[0]){
                    nowHealth -= attack[1];
                    if(nowHealth<=0){
                        answer = -1;
                        break;
                    }
                    healCount=0;
                    attackIndex++;
                    answer = nowHealth;
                    continue;
                }

                //heal
                heal();
                answer = nowHealth;
            }
            return answer;
        }

        private void init(int[] bandage, int health) {
            skillLength= bandage[0];
            healing= bandage[1];
            plusHeal= bandage[2];
            maxHealth= health;
            nowHealth=maxHealth;
        }

        private void heal(){
            healCount++;
            if(healCount == skillLength){
                nowHealth= nowHealth + healing+plusHeal;
                healCount=0;
            }else{
                nowHealth+=healing;
            }

            if(nowHealth > maxHealth) {
                nowHealth = maxHealth;
            }
        }
    }