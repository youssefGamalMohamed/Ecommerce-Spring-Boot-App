package com.app.ecommerce.models.response.success;

import com.app.ecommerce.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetOrderStatusById {
	
	private Status orderStatus;
}
