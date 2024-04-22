package com.peralta.financenow.controller;

import com.peralta.financenow.domain.model.request.filter.FilterRequest;
import com.peralta.financenow.domain.model.response.DataListResponse;
import com.peralta.financenow.domain.model.response.filter.FilterResponseMap;
import com.peralta.financenow.service.filter.FilterFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "filter")
@CrossOrigin(origins = "*")
public class FilterController <R> {

    private final FilterFacade<R> filterFacade;

    public FilterController(FilterFacade<R> filterFacade) {
        this.filterFacade = filterFacade;
    }

    @GetMapping
    public DataListResponse<FilterResponseMap<R>> getFiltersResponse(
            @RequestParam(name = "pageSize") Long pageSize,
            @RequestParam(name = "filterKeys") List<Long> filterKeys,
            @RequestParam(name = "strSearch") String strSearch,
            @RequestParam(name = "relatedIds") List<Long> relatedIds
    ) {
        return filterFacade.getFilters(FilterRequest.builder().build());
    }

}
