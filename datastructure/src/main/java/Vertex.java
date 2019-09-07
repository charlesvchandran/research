import java.util.Objects;

public class Vertex {
    String label;

    Vertex(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex vertex = (Vertex) o;
        return label == vertex.label && Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
