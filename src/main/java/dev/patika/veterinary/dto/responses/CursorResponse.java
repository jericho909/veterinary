package dev.patika.veterinary.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursorResponse <T>{
    private int pageNumber;
    private int pageSize;
    private long totalElement;
    private List<T> items;
}
