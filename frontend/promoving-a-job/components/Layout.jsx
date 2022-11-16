import Navbar from './Navbar/Navbar';

const Layout = ({ children }) => {
    return (
        <>
            <Navbar />
            <main>{children}</main>
            <footer></footer>
        </>
    );
};

export default Layout;
