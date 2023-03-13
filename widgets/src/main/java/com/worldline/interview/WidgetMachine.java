package com.worldline.interview;

public class WidgetMachine {
    private InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.PETROL);
    private SteamEngine steamEngine = new SteamEngine(FuelType.WOOD);

    public int produceWidgets(int quantity, int fuelLevel, boolean isSteamEngine) {
        int cost = 0;

        if (isSteamEngine) {
            steamEngine.fill(FuelType.WOOD, fuelLevel);
            steamEngine.start();

            if (steamEngine.isRunning()) {
                cost = produce(quantity);
            }

            steamEngine.stop();

        } else {
            engine.fill(FuelType.PETROL, fuelLevel);
            engine.start();

            if (engine.isRunning()) {
                cost = produce(quantity);
            }

            engine.stop();
        }

        return cost;
    }

    private int produce(int quantity, boolean isSteamEngine) {
        int batch = 0;
        int batchCount = 0;
        float costPerBatch = 0;
        int batchSize = isSteamEngine ? 2 : 8;

        if (engine.getFuelType() == FuelType.PETROL) {
            costPerBatch = 9;
        } else if (engine.getFuelType() == FuelType.DIESEL) {
            costPerBatch = 12;
        } else if (engine.getFuelType() == FuelType.WOOD) {
            costPerBatch = 4.35;
        } else if (engine.getFuelType() == FuelType.COAL) {
            costPerBatch = 5.65;
        }

        while (batch < quantity) {
            batch = batch + batchSize;
            batchCount++;
        }

        return batchCount * costPerBatch;
    }


}
