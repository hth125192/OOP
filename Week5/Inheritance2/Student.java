public class Student extends Person {
    private String program;
    private int year;
    private double fee;

    /**
     * Constructor.
     *
     * @param name    name
     * @param address address
     * @param program program
     * @param year    year
     * @param fee     fee
     */
    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.fee = fee;
        this.program = program;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student[" + super.toString()
                + ",program=" + program
                + ",year=" + year
                + ",fee=" + fee + "]";
    }

    public double getFee() {
        return fee;
    }

    public int getYear() {
        return year;
    }

    public String getProgram() {
        return program;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
