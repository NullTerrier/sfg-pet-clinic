package marek.makuch.sfgpetclinic.services.map;
/*
 * @author Marecki
 */

import marek.makuch.sfgpetclinic.model.Owner;
import org.springframework.stereotype.Service;
import marek.makuch.sfgpetclinic.services.OwnerService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        List<Map.Entry<Long, Owner>> found = super.map.entrySet().stream()
                .filter(e -> e.getValue().getLastName().equals(lastName))
                .collect(Collectors.toList());
        return (Owner) found.get(0);
    }
}
