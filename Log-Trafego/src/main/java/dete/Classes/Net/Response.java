package dete.Classes.Net;

import java.util.Objects;

public class Response {
    private Long response;

    public Response(Long response) {
        this.response = response;
    }

    public void insertResponse(Long response){
        this.response = response;
    }

    public long getResponseMs() {
        return response;
    }

    @Override
    public String toString() {
        return "Tempo de resposta: " + response + "ms";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Response response1 = (Response) o;
        return Objects.equals(response, response1.response);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(response);
    }
}
