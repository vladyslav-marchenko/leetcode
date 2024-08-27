package com.leetcode.thread;

public class ProducerAndConsumer {

    public static void main(String[] args) {
        String finalPackage = "-";
        String[] dataPackages = new String[]{"A", "B", "C", "D", "E", "F", "G", finalPackage};
        DataService dataService = new DataService();

        Thread producerThread = new Thread(new DataProducer(dataPackages, dataService));
        Thread consumerThread = new Thread(new DataConsumer(finalPackage, dataService));

        producerThread.start();
        consumerThread.start();
    }

    private record DataProducer(String[] dataPackages, DataService dataService) implements Runnable {

        @Override
            public void run() {
                for (String dataPackage : dataPackages) {
                    dataService.sendData(dataPackage);
                    System.out.println("DataProducer sends package: " + dataPackage);
                }
            }

        }

    private record DataConsumer(String finalPackage, DataService dataService) implements Runnable {

        @Override
            public void run() {
                String dataPackage;
                do {
                    dataPackage = dataService.receiveData();
                    System.out.println("DataConsumer receives package: " + dataPackage);
                } while (!finalPackage.equals(dataPackage));
            }

        }

    private static class DataService {

        private String currentDataPackage;
        private boolean sending = true;

        public synchronized void sendData(String dataPackage) {
            while (!sending) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Exception on data sending", e);
                }
            }
            currentDataPackage = dataPackage;
            sending = false;
            notify();
        }

        public synchronized String receiveData() {
            while (sending) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Exception on data receiving", e);
                }
            }
            sending = true;
            notify();
            return currentDataPackage;
        }

    }

}
