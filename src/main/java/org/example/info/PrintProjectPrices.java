package org.example.info;

public class PrintProjectPrices {
    private int projectId;
    private String clientName;
    private double projectCost;

    public PrintProjectPrices() {
    }

    public PrintProjectPrices(int projectId, String clientName, double projectCost) {
        this.projectId = projectId;
        this.clientName = clientName;
        this.projectCost = projectCost;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getProjectCost() {
        return projectCost;
    }

    public void setProjectCost(double projectCost) {
        this.projectCost = projectCost;
    }

    @Override
    public String toString() {
        return "PrintProjectPrices{" +
                "projectId=" + projectId +
                ", clientName='" + clientName + '\'' +
                ", projectCost=" + projectCost +
                '}';
    }
}
