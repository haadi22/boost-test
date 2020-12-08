/**
 * 
 */
package test.project.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author shaiful
 * @date   14 Aug 2019
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor(access=AccessLevel.PUBLIC)
public class Status {

	private Integer code;
	
	private String message;
	
}
