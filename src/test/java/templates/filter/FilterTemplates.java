package templates.filter;

import com.peralta.financenow.domain.model.request.filter.FilterRequest;
import com.peralta.financenow.domain.model.response.filter.FilterResponse;

import java.util.List;

public class FilterTemplates {

    public static FilterRequest getFilterRequest() {
        return FilterRequest.builder()
                .strSearch("strSearch")
                .filterKeys(List.of(0L))
                .relatedIds(List.of(1L))
                .pageSize(10L)
                .build();
    }

    public static FilterResponse getFilterResponse() {
        return FilterResponse.builder()
                .id(1L)
                .value("Value")
                .build();
    }
}
