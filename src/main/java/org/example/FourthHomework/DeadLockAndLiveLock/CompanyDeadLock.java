package org.example.FourthHomework.DeadLockAndLiveLock;

// DeadLock пример: Борьба за ресурсы между отделами
public class CompanyDeadLock {
    // Ресурсы компании
    private final Object productionServer = new Object();
    private final Object databaseServer = new Object();

    class DevelopmentTeam implements Runnable {
        private final String teamName;

        public DevelopmentTeam(String teamName) {
            this.teamName = teamName;
        }

        public void deployToProduction() {
            synchronized (productionServer) {
                System.out.println(teamName + " захватил Production сервер");

                // Имитация работы
                try {
                    Thread.sleep(100);
                    System.out.println(teamName + " настраивает deployment...");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                // Попытка получить доступ к базе данных
                System.out.println(teamName + " пытается получить доступ к Database серверу...");
                synchronized (databaseServer) {
                    System.out.println(teamName + " захватил Database сервер");
                    System.out.println(teamName + " успешно завершил deployment!");
                }
            }
        }

        public void updateDatabase() {
            synchronized (databaseServer) {
                System.out.println(teamName + " захватил Database сервер");

                // Имитация работы
                try {
                    Thread.sleep(100);
                    System.out.println(teamName + " выполняет миграцию базы данных...");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                // Попытка получить доступ к production
                System.out.println(teamName + " пытается получить доступ к Production серверу...");
                synchronized (productionServer) {
                    System.out.println(teamName + " захватил Production сервер");
                    System.out.println(teamName + " успешно обновил базу данных!");
                }
            }
        }

        @Override
        public void run() {
            if (teamName.equals("Frontend Team")) {
                deployToProduction();
            } else {
                updateDatabase();
            }
        }
    }
}
