package org.example.info;

public class MaxProjectCountClient {
        private String name;
        private int projectCount;

        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getProjectCount() {
            return projectCount;
        }

        public void setProjectCount(int projectCount) {
            this.projectCount = projectCount;
        }

        @Override
        public String toString() {
            return "MaxProjectCountClient{" +
                    "name='" + name + '\'' +
                    ", projectCount=" + projectCount +
                    '}';
        }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
