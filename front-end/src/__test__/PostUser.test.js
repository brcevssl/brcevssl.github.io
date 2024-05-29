import PostUser from '../pages/employee/PostUser';
import { render, screen } from "@testing-library/react";

test('Dashboard component text test', () => {
    render(<PostUser />);
    const specificText = screen.getByText('Post New Employee');
    expect(specificText).toBeInTheDocument();
  });
  