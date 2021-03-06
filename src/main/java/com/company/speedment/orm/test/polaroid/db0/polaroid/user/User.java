package com.company.speedment.orm.test.polaroid.db0.polaroid.user;

import com.company.speedment.orm.test.polaroid.db0.polaroid.image.Image;
import com.company.speedment.orm.test.polaroid.db0.polaroid.image.ImageManager;
import com.company.speedment.orm.test.polaroid.db0.polaroid.link.Link;
import com.company.speedment.orm.test.polaroid.db0.polaroid.link.LinkManager;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.annotation.Generated;

/**
 * An interface representing an entity (for example, a row) in the Table 'polaroid.db0.polaroid.user'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment.
 * Any changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment 
 */
@Generated("Speedment")
public interface User {
    
    Long getId();
    
    String getMail();
    
    String getPassword();
    
    String getFirstName();
    
    String getLastName();
    
    String getAvatar();
    
    default Stream<Image> imagesByUploader() {
        return ImageManager.get()
                .stream().filter(image -> Objects.equals(this.getId(), image.getUploader()));
    }
    
    default Stream<Link> linksByFollower() {
        return LinkManager.get()
                .stream().filter(link -> Objects.equals(this.getId(), link.getFollower()));
    }
    
    default Stream<Link> linksByFollows() {
        return LinkManager.get()
                .stream().filter(link -> Objects.equals(this.getId(), link.getFollows()));
    }
    
    default Stream<Image> images() {
        return imagesByUploader();
    }
    
    default Stream<Link> links() {
        return Stream.of(linksByFollower(), linksByFollows()).flatMap(Function.identity()).distinct();
    }
    
    static UserBuilder builder() {
        return UserManager.get().builder();
    }
    
    default UserBuilder toBuilder() {
        return UserManager.get().toBuilder(this);
    }
    
    static Stream<User> stream() {
        return UserManager.get().stream();
    }
    
    default Optional<User> persist() {
        return UserManager.get().persist(this);
    }
    
    default Optional<User> update() {
        return UserManager.get().update(this);
    }
    
    default Optional<User> remove() {
        return UserManager.get().remove(this);
    }
}