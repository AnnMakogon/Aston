package org.example.FourthHomework.DeadLockAndLiveLock;

//LiveLock пример: Слишком вежливые тимлиды
public class CompanyLiveLock {
    private volatile boolean isCodeReviewInProgress = false;
    private volatile int meetingRoomAvailability = 1; // 1 - свободна

    class TeamLead {
        private final String name;
        private final String team;

        public TeamLead(String name, String team) {
            this.name = name;
            this.team = team;
        }

        public void conductCodeReview(TeamLead otherLead) {
            while (!Thread.currentThread().isInterrupted()) {
                if (!isCodeReviewInProgress && meetingRoomAvailability == 1) {
                    // Вежливо уступаем другому
                    if (otherLead.isWaitingLonger()) {
                        System.out.println(name + " (" + team + "): " +
                                "Нет, нет, вы сначала проводите code review...");
                        continue;
                    }

                    isCodeReviewInProgress = true;
                    meetingRoomAvailability = 0;

                    System.out.println(name + " (" + team + "): " +
                            "Начинаю code review для команды " + team);

                    // Имитация code review
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println(name + " (" + team + "): " +
                            "Code review завершен! Передаю очередь...");

                    isCodeReviewInProgress = false;
                    meetingRoomAvailability = 1;
                    return;

                } else {
                    // Ждем своей очереди
                    System.out.println(name + " (" + team + "): " +
                            "Жду когда освободится переговорка...");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        // Фиктивный метод для демонстрации "вежливости"
        public boolean isWaitingLonger() {
            return Math.random() > 0.5;
        }
    }
}
